# Fish Engine

Why a fish? Who knows. Anyway...

## Engine Features

* Keyboard Input
* Graphics
    * Screen rendering
    * Sprites
* Basic "Camera" movement 

## Basic structure

This engine uses JFrame and AWT to create a frame and canvas. The Game class is currently the main class handling everything. This will be pulled out later once the engine is more complete.
The eventual idea is to use this as a library of course, not internally within the library. It is just much easier to do testing and development this way.

## Graphics Module

* Screen
* Sprite
* SpriteSheet

### Screen
The Screen class handles all the visual drawing to the screen. Currently that can be custom raw graphics or sprites.

### Sprite
The Sprite class pulls a sprites pixels from the a given spritesheet and manages them. This is how we draw individual sprites.

### SpriteSheet
The SpriteSheet class loads an image and creates an array of its pixels.

## Input Module

* Keyboard

### Keyboard
The Keyboard class implements KeyListener. This is used as a keyListener on the AWT Canvas. This class provides a boolean array for the keys as well as some helpers for up, down, left, and right.

## ChangeLog

More details and notes taken during development can be seen on the individual branches linked below.

It is highly recommended to look at these for demo images and gifs.

* [01 - setup](https://github.com/djpeach/FishEngine/tree/01-setup) 
    > This step focused on setting up the project structure and ended with the first rendition of the Screen class.
* [02 - graphics](https://github.com/djpeach/FishEngine/tree/02-graphics)
    > This step focused on the Screen class and learning how to get pixel data out of an image.
* [03 - implementation](https://github.com/djpeach/FishEngine/tree/03-implementations)
    > This step started to implement some of the features we had. This was done by drawing tiles and different colors on the screen.
* [04 - input](https://github.com/djpeach/FishEngine/tree/04-input)
    > This step showed how to accept keyboard input and use that to move the "camera" around an infinite map
* [05 - sprites](https://github.com/djpeach/FishEngine/tree/05-sprites)
    > This step created the SpriteSheet and Sprite class and then ended by using them in the Screen class to draw a repeating background from a custom sprite
