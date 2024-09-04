#!/bin/bash

# Install Git
sudo yum install git -y

# Clone the repository
git clone https://github.com/dcocuzza/ecommerce-cloud.git

# Update repository
current_dir=$(pwd)
cd /home/ec2-user/ecommerce-cloud
git pull 
cd "$current_dir"

# Install Docker
sudo yum install docker -y
sudo systemctl start docker
sudo usermod -aG docker ec2-user
newgrp docker

# Pull Docker images
docker pull danielecocuzza/device-shop:client
docker pull danielecocuzza/device-shop:server
docker pull danielecocuzza/device-shop:session

# Install kubectl
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
chmod +x kubectl
sudo mv kubectl /usr/local/bin/

# Install Minikube
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube && rm minikube-linux-amd64