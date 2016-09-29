# Prepreg Data Tracker



## Introduction and Definition of Goals



### Approach

Prepregs („preimpregnated fibres“) are preimpregnated textile pre-products, which are used for producing Components under usage of temperature and pressure. These Prepregs are available as rolls, which ensures easy processing. This allows for an automated Production-Process. The challenge here is to find a Set of Parameters (e.g. different Temperatures, Pressures, etc.) to obtain a desired result. This Set of Parameters, which is called „Recipe“, can be found by running multiple Experiments and evaluating each result. The evaluation Process consists of writing down each Parameter and reviewing the result. If the result does not match the desired characteristics the Parameters need to be changed accordingly.



### Goal

Of course writing down each Recipe and Review takes time and for that is very inefficient. The Goal is to automate this process, so all Changes made to the Recipe are automatically stored and can then be viewed after finishing a set of Experiments. The researcher can then exactly tell at which point, what parameters have been used.



### Solution

This issue can be solved by creating a Software that connects to the Prepreg-Plant and automatically detects any change made by the researcher. These changes need to be saved first, so the researcher can review them later. After reviewing the Results the User must be able to export the Data. This not only optimizes the Workflow of experimenting with different Recipes and reviewing the results but also simplifies the evaluation process.



### Overview

 ![Bildschirmfoto 2016-09-29 um 11.09.03](/Users/Masi/Desktop/Bildschirmfoto 2016-09-29 um 11.09.03.png)



## Product Overview



### Concept Description

* The Software should autmatically connect to the Plant
* Recipe Changes need to be detected automatically
* User should be able to review all recorded Changes
* Manual Input of static Data should be possible
* The Software should have options to filter and select specific Datasets
* The Data must be exportable as Excel Sheets



### Description of used Interfaces and Frameworks

* **Libnodave / [S7Connector](https://github.com/rudin-io/s7connector):**
  The S7Connector is a Java Port of the Libnodave Project, which is a library for exchanging Data with a Siemens Somatic S7 CPU.

* **Apache Derby:**

  Derby is and embedded Java Database, that is used to store the Data which is gathered from the Siemens PLC.

* **JavaFX / [UndecoratorBis](https://github.com/in-sideFX/UndecoratorBis):**
  The Frontend is based on the JavaFX Framework. The UndecoratorBis Project allows to create a modern Look and Feel adapted from the ModernUI developed by Microsoft.

* **Spring:**
  The Spring Project is used for the Business Logic. It ensures that the Application follows all best practices and requirements for an enterprise Java Project.



## Product Details



### Use-Cases

 ![Bildschirmfoto 2016-09-29 um 11.25.06](/Users/Masi/Desktop/Bildschirmfoto 2016-09-29 um 11.25.06.png)



### Frontend-Layout

 ![Bildschirmfoto 2016-09-29 um 11.26.07](/Users/Masi/Desktop/Bildschirmfoto 2016-09-29 um 11.26.07.png)

 ![Bildschirmfoto 2016-09-29 um 11.26.30](/Users/Masi/Desktop/Bildschirmfoto 2016-09-29 um 11.26.30.png)

 ![Bildschirmfoto 2016-09-29 um 11.26.57](/Users/Masi/Desktop/Bildschirmfoto 2016-09-29 um 11.26.57.png)

