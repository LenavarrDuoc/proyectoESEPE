======================================================
Oracle Free Use Terms and Conditions (FUTC) License 
======================================================
https://www.oracle.com/downloads/licenses/oracle-free-license.html
===================================================================

ojdbc10-full.tar.gz - JDBC Thin Driver and Companion JARS
========================================================
This TAR archive (ojdbc10-full.tar.gz) contains the 19.29.0.0 release of the Oracle JDBC Thin driver(ojdbc10.jar), the Universal Connection Pool (ucp.jar) and other companion JARs grouped by category. 

(1) ojdbc10.jar (4570665 bytes) - 
(SHA1 Checksum: 5af7bacea931d6afa12636360a056c3eb8ccd177)
Oracle JDBC Driver compatible with JDK8, JDK9, and JDK11;
(2) ucp.jar (1701061 bytes) - (SHA1 Checksum: 8a94b4af8aa1934affd8fef948a5c7164e434c4c)
Universal Connection Pool classes for use with JDK8, JDK9, and JDK11 -- for performance, scalability, high availability, sharded and multitenant databases.
(3) ojdbc.policy (12134 bytes) - Sample security policy file for Oracle Database JDBC drivers

======================
Security Related JARs
======================
Java applications require some additional jars to use Oracle Wallets. 
You need to use all the three jars while using Oracle Wallets. 

(4) oraclepki.jar (312528 bytes ) - (SHA1 Checksum: e461dbd4729cbc72979d0c11309b03c1bfbf8e82
Additional jar required to access Oracle Wallets from Java
(5) osdt_cert.jar (210641 bytes) - (SHA1 Checksum: 0c9bca13e69c2ae3d18bd5f2904984a186a7860f)
Additional jar required to access Oracle Wallets from Java
(6) osdt_core.jar (313844 bytes) - (SHA1 Checksum: 7e0e3db39b7680e9207d11a4608935cf85020faf)
Additional jar required to access Oracle Wallets from Java

=============================
JARs for NLS and XDK support 
=============================
(7) orai18n.jar (1664184 bytes) - (SHA1 Checksum: 80ddf5d76231548492e439e99e26b4a234136bc9) 
Classes for NLS support
(8) xdb.jar (131998 bytes) - (SHA1 Checksum: 788ea7ca7b5d46ae7cdbe4a55f385f41d71ca7bd)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 
(9) xmlparserv2.jar (1934309 bytes) - (SHA1 Checksum: 3402dd3b828ecb671e5398a7dfb7922f3fb894db)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 
(10) xmlparserv2_sans_jaxp_services.jar (1933215 bytes) - (SHA1 Checksum: 95c006b47e899c4f1e537c6cee7f11f4a63d1088) 
Classes to support standard JDBC 4.x java.sql.SQLXML interface

====================================================
JARs for Real Application Clusters(RAC), ADG, or DG 
====================================================
(11) ons.jar (157057 bytes ) - (SHA1 Checksum: ea47896efbb697f3a9195017362cbfaaefe80d95)
for use by the pure Java client-side Oracle Notification Services (ONS) daemon
(12) simplefan.jar (32397 bytes) - (SHA1 Checksum: 5259690a641357a5864556b25b96cd78ac138d35)
Java APIs for subscribing to RAC events via ONS; simplefan policy and javadoc

==================================================================================
NOTE: The diagnosability JARs **SHOULD NOT** be used in the production environment. 
These JARs (ojdbc10_g.jar,ojdbc10dms.jar, ojdbc10dms_g.jar) are meant to be used in the 
development, testing, or pre-production environment to diagnose any JDBC related issues. 

=====================================
OJDBC - Diagnosability Related JARs
===================================== 

(13) ojdbc10_g.jar (7647144 bytes) - (SHA1 Checksum: c2646f2ae12f619d31acc7336d49173e21213545)
Same as ojdbc10.jar except compiled with "javac -g" and contains tracing code.

(14) ojdbc10dms.jar (6356628 bytes) - (SHA1 Checksum: 592199fe56f1203708c2084cf79c5a5acf865023)
Same as ojdbc10.jar, except that it contains instrumentation to support DMS and limited java.util.logging calls.

(15) ojdbc10dms_g.jar (7676823 bytes) - (SHA1 Checksum: af658a6bc81fefc7f2c03d48b9d6daee8f94893d)
Same as ojdbc10_g.jar except that it contains instrumentation to support DMS.

(16) dms.jar (2194533 bytes) - (SHA1 Checksum: cb20f6da4888d906ae44013dbec2cec0880d9941)
dms.jar required for DMS-enabled JAR files.

==================================================================
Oracle JDBC and UCP - Javadoc and README
==================================================================

(17) JDBC-Javadoc-19c.jar (2314152 bytes) - JDBC API Reference 19c

(18) ucp-Javadoc-19c.jar (366845 bytes) - UCP Java API Reference 19c

(19) simplefan-Javadoc-19c.jar (84131 bytes) - Simplefan API Reference 19c 

(20) xdb-Javadoc-19c.jar (2861664 bytes) - XDB API Reference 19c 

(21) xmlparserv2-Javadoc-19c.jar (2861664 bytes) - xmlparserv2 API Reference 19c 

(22) Jdbc-Readme.txt: It contains general information about the JDBC driver and bugs that have been fixed in the 19.29.0.0 release. 

(23) UCP-Readme.txt: It contains general information about UCP and bugs that are fixed in the 19.29.0.0 release. 


=================
USAGE GUIDELINES
=================
Refer to the JDBC Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/19/jjdbc/index.html) and Universal Connection Pool Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/19/jjucp/index.html) for more details.
