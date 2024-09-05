#!/bin/bash

# Start Minikube
minikube start 


# Apply Kubernetes configurations
kubectl apply -f ecommerce-cloud/device-shop-client-deployment.yaml 
kubectl apply -f ecommerce-cloud/device-shop-server-deployment.yaml
kubectl apply -f ecommerce-cloud/device-shop-session-deployment.yaml
kubectl apply -f ecommerce-cloud/device-shop-client-service.yaml 
kubectl apply -f ecommerce-cloud/device-shop-server-service.yaml 
kubectl apply -f ecommerce-cloud/device-shop-session-service.yaml
#kubectl apply -f ecommerce-cloud/device-shop-server-lb.yaml
#kubectl apply -f ecommerce-cloud/device-shop-server-nodeport.yaml

 