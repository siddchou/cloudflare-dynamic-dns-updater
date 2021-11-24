# cloudflare-dynamic-dns-updater

This code provides capability to update IPV4 address for cloudflare 

#Steps done in code 

1. Call  https://myip.dnsomatic.com  to fetch the Public API address 
2. Call Cloudflare API to fetch A records for a ZONE ID 
3. Check if there is difference between IP address 
4. If there is a diffrence make a call to update the record 


#To Use 
1. checkout the project
2. go to src/main/resources and change application.properties 

        Change below variables 

        #port for APP & APi's
        server.port=8888
        #Time interval in minutes for scheduler to Run
        fixedDelay.in.minutes=20
        #cloudflare ZoneID
        cloudflare.zoneid=
        #cloudflare user EMAIL ID
        cloudflare.authEmail=
        #cloudflare GLOBALKEY
        cloudflare.key=
        #comma seprated Domain Names  example   test.com  subdomain.test.com
        cloudflare.domainNames=

3. Run the command to build     
            
            mvn clean package 
            
4. Use docker to build image 

            docker build --tag=cloudflare-ddns-update:latest .

5. Run Docker Image 

            docker run -p8080:8888 cloudflare-ddns-update:latest
