# ping-pong-game
2 player game

# ./game
  ## Game is responsible for the entire game process
  ## Handler handles object interactions and separate manipulations such as moving and rendering objects
  ## KeyInput binds W-S and key_UP-key_DOWN controls
  ## Window is for creating the window

# ./game/objects
  ## Ball - a bouncing in the area ball
  ## Brick - a left or right bar, reflects the ball
  ## GameObject (abstract) - organises Balls and Bricks
  ## ID (enum) - contains IDs of the objects
