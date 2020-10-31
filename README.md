# The Game Class

A lot of the things we need to set up will initially be put in a generic game class. We may change this later to break things up more. But for the "sketching" phase, this will be fine.

## Screen setings

The screen's width and height are set. The height is set using a ratio (16x9). Then the game can be scaled as small or large as needed using a scalar from there.

The inital settings are 300 x (300 / (16/9)), scaled by 3.


## Game thread

A game engine has many responsibilities, and while simple games can run in one thread, using multiple threads for things like update logic, display logic, audio, etc, can make the game run faster. 
There is the responsibility of ensuring that the threads are not out of sync, they do not overwrite shared resources incorrectly and so on, but if used correctly, will create a better engine.

### `synchronized` keyword

The `synchronized` keyword defines a code block which will use [`monitors`](https://www.tutorialspoint.com/java/java_thread_synchronization.htm) to protect shared resources.

Read more here: https://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html

## Game Loop

Since the game loop will the implemented in the Thread's run method, we will use an external variable to determine if it should stop. The stop method will change this first, which will in turn cause the main while loops in the threads to stop and join back to the main thread.

## Canvas

The canvas come from the built in `java.awt` package. That is the [Abstract Window Toolkit](https://docs.oracle.com/javase/8/docs/technotes/guides/awt/).

In the constructor, we create and set the dimensions of the canvas using the settings from earlier.
We also create the main JFrame to work with.

Finally, in our main method to run everything, we just set the JFrame properties we want and run it.

## Buffer Strategy

We need to max our update at 60 frames per seconds and normalize movement using a delta.
We can render as fast as the clients computer lets us.

A buffer allows us to write all our visual changes to one spot, then only once it is ready, it will be swapped out for the live version the user sees. These two buffers will switch back and forth.
A buffer is already given to us from the Canvas class we are extending. 

We are using a 3-buffer strategy in case we can start calculating up to two buffers in one frame, if we get the chance. 
This will only happen if the computer is fast enough to do so of course. This prevents frames from waiting to be calculated on fast cpu's.

Swapping the buffers is often called blitting.

## Graphics

We will get the draw graphics, make changes, and then release the resources.
Graphics changes and objects to draw are created like any other "native" graphics class in other languages.


 ## Raster
 
 The raster is the pixel representation of an image. In java.awt, it is a single dimensional array of pixels.
 We can use the raster to individually change, delete, and otherwise mutate the pixels that make up the image.
 
 ## Demo
 
 At this point, just a blank screen with a custom color. This is just a huge rect drawn by the AWT Graphics Module.
 ![image](https://user-images.githubusercontent.com/31779571/97770307-6e59cf80-1b08-11eb-9839-726cd2765bdc.png)

 
 


