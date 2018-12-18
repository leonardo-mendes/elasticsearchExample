path=$(shell pwd)

start:
	docker-compose -f docker-dev.yml pull
	docker-compose -f docker-dev.yml up -d

stop:
	docker-compose -f docker-dev.yml down

restart: | stop start
