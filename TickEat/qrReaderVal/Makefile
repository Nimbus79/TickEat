.PHONY: help prepare-dev test lint run doc

VENV_NAME?=venv
VENV_ACTIVATE=. $(VENV_NAME)/bin/activate
PYTHON=${VENV_NAME}/bin/python3
SHELL := /bin/bash

.DEFAULT: help
	
help:
	@echo "make prepare-dev"
	@echo "       prepare development environment, use only once (Only work on debian distros)"
	@echo "make venv"
	@echo "       Create and install the Requirements of python script"
	@echo "make run"
	@echo "       run project"
	@echo "make clean"
	@echo "       Clean development environment"


prepare-dev:
	which dpkg-buildpackage || apt install -y debhelper dh-virtualenv dh-systemd lintian
	apt install python-pip
	which python3 || apt install -y python3 python3-pip
	apt install virtualenv
	python3 -m pip install virtualenv
	apt-get install libzbar0

# Requirements are in setup.py, so whenever setup.py is changed, re-run installation of dependencies.
venv:
	@echo $(id) > rasp.id
	test -d $(VENV_NAME) || virtualenv --python python3 $(VENV_NAME)
	chmod 755 $(VENV_NAME)/bin/activate
	source $(VENV_NAME)/bin/activate
	${PYTHON} setup.py install
	touch $(VENV_NAME)/bin/activate

run: venv
	${PYTHON} build/lib/src/qrReaderVal.py

clean:
	rm -rf $(VENV_NAME) $(objects)
	rm -rf qrcode.*
	rm -rf build*
	rm -rf dist*
	rm -rf __py*
	rm -rf rasp.id
	pip uninstall qrReaderVal