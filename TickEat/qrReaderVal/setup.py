#!/usr/bin/env python

from setuptools import setup, find_packages

setup(
    name='qrReaderVal',
    version='1.0',
    description='',
    author='Tickeat',
    author_email='tickeat@hotmail.com',
    packages= find_packages(exclude=['tests']),
    url='https://github.com/87Beggar/TickEat',

    # All versions are fixed just for case. Once in while try to check for new versions.
    install_requires=[
    'imutils>=0.5.3',
    'pyzbar>=0.1.8',
    'requests>=2.17.3',
    'opencv-python>=4.1.2.30',
    ],

    )