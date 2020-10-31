# Graphics Module

The engine will include a module to handle all things related to graphics.

## Screen Class

The screen class will be responsible for managing the pixels to be rendered.

We will create a render method to loop over our pixels and make any changes. The screen class's pixels can be used by other classes to display them.

## Update Timer

To lock our update loop at 60 times per second, we need to find the current time minus the last time the loop ran. This is called our delta.
If our delta is greater than a 1/60th of a second, we can run the update loop. In order to deal with lags and cpus faster than this, we increase delta by 
the current time less the last time. Then we run a while loop for every 1/60th of a second of delta, decrementing delta as we do, until it is < 1/60th of a second.

## FPS Timer

To calculate fps, we just count the updates and frames and once ever second, rest them and post them to the screen.

## Demo

This time just a pink screen but instead of a large rect with the Graphics module, it is a pixel by pixel manipulation in the new Screen class. We turn the 1D array into proper x and y coordinates and turn all pixels pink.

![image](https://user-images.githubusercontent.com/31779571/97770339-bd076980-1b08-11eb-86d2-dbef854d9977.png)


