""" 
Usa python 3
se necesita scipy

"""

import scipy.optimize as sciOpt
import math
import random
# the function to optimize
func = lambda r: -sum(x*math.sin(math.sqrt(abs(x))) for x in r) - (0 if sum(1 for x in r if x>500 or x<-500)<1 else 1000)

random.random()
x = random.uniform(-500, 500)
y = random.uniform(-500, 500)
z = random.uniform(-500, 500)

# use the anneal function
ret = sciOpt.basinhopping(func,[x,y,z],200,1.0)
# print the result
l = func(ret.x)
print(str(ret.x)+" -> "+str(l))
