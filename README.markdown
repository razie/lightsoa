    /**  ____    __    ____  ____  ____/___      ____  __  __  ____
     *  (  _ \  /__\  (_   )(_  _)( ___) __)    (  _ \(  )(  )(  _ \
     *   )   / /(__)\  / /_  _)(_  )__)\__ \     )___/ )(__)(  ) _ <
     *  (_)\_)(__)(__)(____)(____)(____)___/    (__)  (______)(____/
     *                      
     *  Copyright (c) Razvan Cojocaru, 2007+, Creative Commons Attribution 3.0
     */

What?
-------

Lightsoa is a simple set of annotations for remote methods.



Roadmap
-------

Not maintained anymore.


Why "lightsoa" ?
===============

While it is normal design practice of having corresponding service/methods represented by Java/Scala classes/methods, I have yet to see a very easy way to just annotate them and have them remoted via REST or whatever...

Besides, I have quite a number of classes using these annotations since '07 that it's easier this way...

How?
----

In the sbt Project file for your project (project/build/Project.scala), add the dependency: 

    val lsoa = "com.razie" %% "lightsoa" % "0.6.3-SNAPSHOT"

Or Maven style:

    <dependency>
        <groupId>com.razie</groupId>
        <artifactId>lightsoa_2.9.1</artifactId>
        <version>0.6.3-SNAPSHOT</version>
    </dependency>



