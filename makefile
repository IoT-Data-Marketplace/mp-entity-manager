build-and-push-to-ecr:
	helm lint ./helm/ --strict
	aws ecr get-login-password --region eu-central-1 --profile mp-ops | docker login --username AWS --password-stdin 543164192837.dkr.ecr.eu-central-1.amazonaws.com/mp-entity-manager
	docker build -t mp-entity-manager .
	docker tag mp-entity-manager:latest 543164192837.dkr.ecr.eu-central-1.amazonaws.com/mp-entity-manager:latest
	docker push 543164192837.dkr.ecr.eu-central-1.amazonaws.com/mp-entity-manager:latest
	helm push ./helm/ iot-data-mp-charts --force