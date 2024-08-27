#!/bin/bash

# Install Git
sudo yum install git -y

# Clone the repository
git clone https://github.com/dcocuzza/ecommerce-cloud.git
cd ecommerce-cloud

# Install Docker
sudo yum install docker -y
sudo systemctl start docker
sudo usermod -aG docker ec2-user
newgrp docker

# Pull Docker images
docker pull danielecocuzza/device-shop:client
docker pull danielecocuzza/device-shop:server
docker pull danielecocuzza/device-shop:session

# Install Minikube
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube && rm minikube-linux-amd64

# Start Minikube
minikube start

# Install kubectl
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
chmod +x kubectl
sudo mv kubectl /usr/local/bin/

# Apply Kubernetes configurations
kubectl apply -f device-shop-client-deployment.yaml
kubectl apply -f device-shop-server-deployment.yaml
kubectl apply -f device-shop-session-deployment.yaml
kubectl apply -f device-shop-client-service.yaml
kubectl apply -f device-shop-server-service.yaml
kubectl apply -f device-shop-session-service.yaml
