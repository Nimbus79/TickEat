# SENHASREADER 

Senhasreader is a program that validates meal tickets through the recognition of QR Codes stored in the app TickEat.

## Installation

```bash
apt install -y debhelper dh-virtualenv dh-systemd lintian
```

```bash
apt-get install libzbar0
```

```bash
apt install -y python3 python3-pip
```

```bash
python3 -m pip install virtualenv
```

```bash
apt-get install libzbar0
```

If you're on an ubuntu machine or resbian:

```bash
make prepare_dev
```

## Usage

Create the virtual environment with the necessary packages.
id -> Identificator of the validation hardware
```bash
make venv id=XYZ
```

Run the program.
```bash
make run
```

Delete the virtual environment.
```bash
make clean
```
