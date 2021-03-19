# SENHASREADER 

Senhareader é um pograma em python que valida senhas atravez do reconhecimento de qrcodes de um utilizador da aplicação tickeat.

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
Se tiveres num ubuntu/resbian

```bash
make prepare_dev
```
## Usage

Criar o virtual environment com os packgages necesarios
id -> é o id da hardware de validação
```bash
make venv id=XYZ
```

Correr o pograma
```bash
make run
```

Remover o virtual environment
```bash
make clean
```
