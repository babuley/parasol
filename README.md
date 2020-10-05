# parasol
Demo/Proof of concept tool for recording, monitoring energy meter readings.
Backend with Spring and hibernate/H2, swagger api and Angular frontend.


#### Home Page
![Example](https://github.com/babuley/parasol/blob/master/examples/EnergyReadingHomePage.png)

#### Sample Dashboard
![Example](https://github.com/babuley/parasol/blob/master/examples/energyReadingDashboard.png)

#### Taking meter readings
![Example](https://github.com/babuley/parasol/blob/master/examples/TakeRecordReading.png)

#### Parasol API doc sample
![Example](https://github.com/babuley/parasol/blob/master/examples/parasolApi.png)


### Examples

- To build full maven project ```mvn install```
- To build docker container for the parasol backend run ```docker build .``` from /parasol/server
- To run parasol services in a container, run ```docker run -p 8888:8888 --name parasol $containerId```
