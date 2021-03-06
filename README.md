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

## Notes and Future Plans

I am enjoying the course I am following here: [Game Programming](https://www.youtube.com/playlist?list=PLlrATfBNZ98c-CeNT-q_Z7ox3R_eIkF98) 

It is written by a professional game engine developer who worked for EA. It is a great change of pace to learn from a pro as opposed to just implementing what I think is best. 
I feel I am learning a lot, and at the very least seeing implementations of things we do in class such as pixel manipulation and boolean array for input and such. 

Right now I am following his implementations pretty strictly, but once I get further along, I plan to heavily modify the code or start from scratch with this as an example of important concepts and standards. 
I then plan to use it to make some sort of game that I really want to be multiplayer if I can get to that point.

## Run the engine

If you want to run this:

* clone it
* compile the files
* run it with JRE 1.8
* if done manually you will need to add the res (resources) directory to your java build path before compiling.

You can do this for any branch to test out the various features.