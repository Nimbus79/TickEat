from pyzbar import pyzbar
from imutils.video import VideoStream
import datetime
import time
import imutils
import argparse
import cv2
import json
import requests

def importid():
    openned = open("rasp.id","r")
    raspid = openned.readlines()
    print(raspid[0])
    return raspid[0].split("\n")[0]

def valida(barcodeData,csv,qrFound):
	jsn = {
		"qrCode": barcodeData, 
		"ferramentaId" : raspid
		}
	try:
		r = requests.post(url, json = jsn)
		t =  r.text
		if "{success : true}" == t:
			csv.write("{},{}\n".format(datetime.datetime.now(),barcodeData))
			csv.flush()
			qrFound.add(barcodeData)
			print("[USER TICKET APPROVED]")
		elif "{success : false}" == t :
			print("[USER DIDNT RESERVED OR ALLREADY USE]")	# This is the correct syntax
		else :
			print("USER NOT RECOGNIZED")
	except Exception:
		print("[SERVER ERROR]")
		

def webDecode():
	print("[Starting]")
	vs = VideoStream(src=0).start()
	time.sleep(2.0)
	csv = open(args["output"], "w")
	qrFound = set()
	try:	
		while True:
			frame = vs.read()
			frame = imutils.resize(frame, width=400)
			barcodes = pyzbar.decode(frame)
			for barcode in barcodes :
				barcodeData = barcode.data.decode("utf-8")
				barcodeType = barcode.type
				print(barcodeData)
				if barcodeData not in qrFound and barcodeType == "QRCODE":
					valida(barcodeData,csv,qrFound)
	except KeyboardInterrupt:
		print("[Shutdown]")
		csv.close()
		cv2.destroyAllWindows()
		vs.stop()


raspid= importid()
ap = argparse.ArgumentParser()
ap.add_argument("-o", "--output", type=str, default="barcodes.csv",
help="path to output CSV file containing barcodes")
args = vars(ap.parse_args())
f = open("url", "r")
url = f.readline()
print(url)
webDecode()
