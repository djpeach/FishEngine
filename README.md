# Implementations

We are going to start to actually use our code now.

## Tiles

To get some stuff on the screen and demo our system, we will render a map of tiles with random colors.
We will create an array of random colors a given rowCount tall and colCount wide.

In our render loop, we then determine what tile the current pixel is over, and use that tile's color to draw to the screen.

## Camera Movement

To move our "Camera", we need to change the offset of the pixels we are drawing. 
For demo purposes, we do this by passing the offset into the render method.
We then use those offsets to determine what color each pixel should be. 

The pixels are all the same, they don't move. 
But the visual illusion is that the areas they are drawn to change since we change what color they should be via the offset.

