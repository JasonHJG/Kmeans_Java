# Kmeans_Java============================= Running Instruction =============================
1. Input: 
To run this program, you need to give one argument. It is either 0 or 1.
If you want to see the results of the first method, use 0. 
If you want to see the result of the second method, use 1.

2. Result:
For each iteration of the updating process, the program will show the ID for the cluster,
the coordinate for each centroid of the cluster and how many points there are in the 
cluster. For example, you will see something like:
****************************************
The cluster is 496
It has 20 points inside
The centroid for the cluster is 5.8,5.8
****************************************


If you want to see more, you can change the boolean verbose in the Kmeans class 
to be true. In that case, you can see what are the points in each cluster. For example, 
you will see something like:
****************************************
The cluster is 499
It has 25 points inside
The centroid for the cluster is 21.24,21.24
The point for the cluster is 19.0,19.0
The point for the cluster is 19.0,20.0
The point for the cluster is 19.0,21.0
The point for the cluster is 19.0,22.0
The point for the cluster is 20.0,19.0
The point for the cluster is 20.0,20.0
The point for the cluster is 20.0,21.0
The point for the cluster is 20.0,22.0
The point for the cluster is 20.0,23.0
The point for the cluster is 21.0,19.0
The point for the cluster is 21.0,20.0
The point for the cluster is 21.0,21.0
The point for the cluster is 21.0,22.0
The point for the cluster is 21.0,23.0
The point for the cluster is 22.0,19.0
The point for the cluster is 22.0,20.0
The point for the cluster is 22.0,21.0
The point for the cluster is 22.0,22.0
The point for the cluster is 22.0,23.0
The point for the cluster is 23.0,20.0
The point for the cluster is 23.0,21.0
The point for the cluster is 23.0,22.0
The point for the cluster is 23.0,23.0
The point for the cluster is 24.0,21.0
The point for the cluster is 24.0,22.0
****************************************

The program will also print the loss (Euclidean distance is used as a measure of loss).
The loss is defined as the average distance from a point to its centroid. You can visualize how does the loss get smaller as K-Means does its job. For example:

==========Method 1=========
The loss looks like: 
Iteration 1 2.0033867899656084
Iteration 2 1.858872958370461
Iteration 3 1.8113333585728821
Iteration 4 1.790378118926673
Iteration 5 1.7777870598740413
Iteration 6 1.767628982147821
Iteration 7 1.7607979024021592
Iteration 8 1.755966650226887
Iteration 9 1.7520940809819472
Iteration 10 1.7499057618552838
Iteration 11 1.747834145790658
Iteration 12 1.7463000949572307
Iteration 13 1.7448231074523326
Iteration 14 1.7437935706027483
Iteration 15 1.7429189672119867
Iteration 16 1.742297023992138
Iteration 17 1.741794805814318
Iteration 18 1.7414815653843994
Iteration 19 1.741229318101277
Iteration 20 1.741065256464044
Iteration 21 1.7410209280417592
Iteration 22 1.740976918637758
Iteration 23 1.7409691127215874



==========Method 2=========
The loss looks like: 
Iteration 1 3.0144366879876237
Iteration 2 2.5114696458148003
Iteration 3 2.4061477325796194
Iteration 4 2.279508050872161
Iteration 5 2.3320709640695605
Iteration 6 2.3358760743533464




============================ Design of the Program ===========================
==================
= Data structure =
==================
This program is done with 5 classes: Point, Cluster, Kmeans, Misc, Pair.
The first three are where the main functionality comes from and the last two are 
helper functions.

Point Object:
Point is the building unit of everything. Each point in the question is represented 
as a Point object. It has:
coordinate: the position of it in the space
clusterID: the cluster it belongs to
occupied: whether it has been assigned to any cluster
pointID: its unique id that differentiates it from other points 

Cluster Object:
Cluster keeps a record of what are the Points object inside one cluster. It has:
centroid: essentially a Point object
points: an arraylist that contains all the points in the cluster
ID: unique ID for each cluster

Kmeans Object:
It is the class where the algorithm works. It has:
MAXDIS: a constant to keep the maximum distance between two points
MAXROUND: the maximum number of updates the algorithm can go if it does not converge
NUMBEROFCLUSTERS: number of clusters
SPACE: the width of the space
THRESHOLD: the number of points -1 in the cluster(for second method)
TOL: the tolerance of error that makes the algorithm stop
verbose: whether to print the information about the points in the cluster
loss: records the average distance from a point to its centroid
allPoints: an arraylist that keeps a record of all the points
allClusters: an arraylist that keeps a record of all the clusters

Misc Object:
Implement the method of randomly generated cluster centers

Pair Object:
Implement the pair in Java


Two methods are implemented as required:
=================
=  First Method =
=================
1.initialize points and clusters in 100x100 space
			
2.assign points to every cluster by finding the distance of point to each cluster

3.set the new cluster center for each cluster

4.stop if the loss does not change
			
=================
= Second Method =
=================
1.initialize points and clusters in 100x100 space
			
2.assign the nearest 20 points to the cluster, use a flag to indicate if the point has 
been assigned to a cluster. Only assign un-assigned points

3.set the new cluster center for each cluster
						
4.stop if the loss does not change			


======================== Comparison of Two Algorithms =======================
Algorithm 1 is robust since we find that we find all points in the cluster really have 
small distance with the cluster centroid. 

Algorithm 2 is not robust because there is a competition among clusters to get a point.
This would give bad clustering for cluster with larger cluster ID since they do not have
precedence in getting the points near them. This is also reflected in the loss of this
method. However this is expected since there is restriction in the size of the cluster.
