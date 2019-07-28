# mobile app server

### **To run dev database** : 
_docker run --rm   --name law -e POSTGRES_PASSWORD=docker -e  POSTGRES_DB=law -d -p 5432:5432  postgres:10-alpine_

### **To create test database** :
_docker exec -i law psql -U postgres -c "CREATE DATABASE law_test WITH ENCODING 'UTF-8'"_

