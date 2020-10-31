# Sprites

Now we will start to show images on the screen

## SpriteSheet Class

First we create a sprite sheet class to load the image. This should be familiar, as we just load the image, and get the individual pixels and store them in a 1D array.
We can then use these pixels later to determine what color we need to use in our Screen's render method

## Sprite Class

For the sprite class, we do many of the same things that we do with the spritesheet class, but instead of loading an image, we use the sheet's image.
We use the position of the sprite passed in to build a individual array of pixels for this given sprite from the sprite sheet.
This way we do not have to load the sheet for every sprite, but only load it once and create all our sprites from it.

## Demo

This is a repeating background of a custom "grass" sprite. This uses the SpriteSheet class to load the image, the Sprite class to get the right pixels, and the Screen class to draw the tiles correctly.

![image](https://user-images.githubusercontent.com/31779571/97770475-01473980-1b0a-11eb-909d-fc79e9d06159.png)
