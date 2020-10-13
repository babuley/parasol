import requests
from random import randint, randrange
import json
import datetime
import time

def toRandomRecord(record): 
    record["customerId"] = randint(0, 1000)
    record["accoutId"] =  randint(0, 100)
    record["value"] = randint(0, 2000)
    record["readingType"] = readingTypes[randint(0, len(readingTypes) - 1)]    
    #2020-10-12T12:12:00
    when = datetime.datetime(2020, randint(1, 12) , randint(1, 28))
    
    record["when"] = when.strftime('%Y-%m-%dT%H:%M:%S.%f')
    print(record["when"])
    return record


parasol_api_address="http://localhost:8888"
versionApi = "v1"
readingTypes = ["gas", "water","electricity"]


#Specify the size of the data set to load
iterations_count=100

#To get the json response, set to true
fullResponse = True

record_string = """
 {"id":"-1","customerId":"-1","accountId":"-1","when":"2020-10-12T12:12:00","value":"-1","readingType":"water"}
 """
record = json.loads(record_string)

#Wait for the env to init
#time.sleep(60)

for i in range(iterations_count):
    record = toRandomRecord(record)
        
    srvEndpoint = "{}/api/{}/records".format(parasol_api_address, versionApi)
    print("URI :%s"%srvEndpoint)
    r = requests.post(url = srvEndpoint, json=record, headers = {"accept": "application/json"})   
    rsp = r
    print(rsp)
    if (fullResponse): rsp = r.text    
    print(" :%s"%i)
    print("Response :%s"%rsp)


