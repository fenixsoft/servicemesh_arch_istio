#!/bin/bash
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin

# frontend
cd ./bookstore-serivcemesh-domain-frontend/
docker build -t bookstore-istio-domain-frontend .
docker tag bookstore-istio-domain-frontend $DOCKER_USERNAME/bookstore-istio-platform-gateway
cd ..

# authentication
cd ./bookstore-serivcemesh-domain-authentication/
docker build -t bookstore-istio-domain-authentication .
docker tag bookstore-istio-domain-authentication $DOCKER_USERNAME/bookstore-istio-domain-authentication
cd ..

# account
cd ./bookstore-serivcemesh-domain-account/
docker build -t bookstore-istio-domain-account .
docker tag bookstore-istio-domain-account $DOCKER_USERNAME/bookstore-istio-domain-account
cd ..

# warehouse
cd ./bookstore-serivcemesh-domain-warehouse/
docker build -t bookstore-istio-domain-warehouse .
docker tag bookstore-istio-domain-warehouse $DOCKER_USERNAME/bookstore-istio-domain-warehouse
cd ..

# payment
cd ./bookstore-serivcemesh-domain-payment/
docker build -t bookstore-istio-domain-payment .
docker tag bookstore-istio-domain-payment $DOCKER_USERNAME/bookstore-istio-domain-payment
cd ..

docker images
docker push $DOCKER_USERNAME/bookstore-istio-domain-frontend
docker push $DOCKER_USERNAME/bookstore-istio-domain-authentication
docker push $DOCKER_USERNAME/bookstore-istio-domain-account
docker push $DOCKER_USERNAME/bookstore-istio-domain-warehouse
docker push $DOCKER_USERNAME/bookstore-istio-domain-payment
