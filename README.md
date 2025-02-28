# L-JGymApp
Repository to support the development of Liam and James' gym app project


MSSQL server details:

Name:GymAppServer
Password:GymAppPassword12!_
Server (whilst running from local machine): localhost,1433


Create server in docker command:
docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=GymAppPassword12!_' -p 1433:1433 --name GymAppServer -d mcr.microsoft.com/mssql/server
