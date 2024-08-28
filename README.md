# ecommerce-cloud

# How to run project  
1. Create a EC2 t3.medium on AWS and access to it
2. Run the following commands:   
   * ``` sudo yum install git -y ```  
   * ``` sudo yum install docker -y ``` 
   * ``` sudo systemctl start docker ``` 
   * ``` sudo usermod -aG docker ec2-user ``` 
   * ``` newgrp docker ``` 
   * ``` docker pull danielecocuzza/device-shop:client ``` 
   * ``` docker pull danielecocuzza/device-shop:server ``` 
   * ``` docker pull danielecocuzza/device-shop:session ``` 
   * ``` curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl" ``` 
   * ``` chmod +x kubectl ``` 
   * ``` sudo mv kubectl /usr/local/bin/ ``` 
   * ``` curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64 ``` 
   * ``` sudo install minikube-linux-amd64 /usr/local/bin/minikube && rm minikube-linux-amd64 ``` 
   * ``` minikube start  ``` 
   * ``` kubectl apply -f ecommerce-cloud/device-shop-client-deployment.yaml  ``` 
   * ``` kubectl apply -f ecommerce-cloud/device-shop-server-deployment.yaml  ``` 
   * ``` kubectl apply -f ecommerce-cloud/device-shop-session-deployment.yaml  ``` 
   * ``` kubectl apply -f ecommerce-cloud/device-shop-client-service.yaml  ``` 
   * ``` kubectl apply -f ecommerce-cloud/device-shop-server-service.yaml  ``` 
   * ``` kubectl apply -f ecommerce-cloud/device-shop-session-service.yaml  ``` 
   * ``` kubectl get pods  ``` 
   * ``` kubectl attach -it <client pod name> -c device-shop-client   ``` 

# How to run project with GitHub Action  
1. Create a EC2 t3.medium on AWS  
2. Open git bash and run the following command:  ``` git clone https://github.com/dcocuzza/ecommerce-cloud.git ```  
3. Push something to the main branch       
4. Open EC2 t3.medium and run  ``` kubectl attach -it <client pod name> -c device-shop-client  ```  for example ```kubectl attach -it  device-shop-client-57f68db6dd-c4r2n -c device-shop-client ```  
