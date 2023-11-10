ArrayList<PVector> snake = new ArrayList<PVector>();
PVector pos;
PVector food;
PVector dir = new PVector(0, 0);
int currentLevel = 1;
boolean nextLevelButtonClicked = false;

// types relating to the snake
int size = 40;
int w, h;
int speed = 20;
int len = 5;
int score = 0;

// to make the head of the snake red when it eats the food
boolean showRedHead = false;
int redHeadTimer = 60;

// for the second game
PVector lava;
int colorLava = 105;
int colorChangeSpeed = 1; 

// an array to store balls in an array whihc makes it easier to modify them 
Ball[] balls = new Ball[10];

// SETUP: the block that runs when the program starts - for initializations
void setup() {
  w = width/size; // ekranın width'ı bölü size, snake'in x ekseni
  h = height/size; // ekranın height'ı bölü size, snake'in y ekseni
  pos = new PVector(w/2, h/2); // snake'in pozisyonu ekranın ortasından başlasın
  food = new PVector(int(random(w)), int(random(h))); // random bir x-y posisyonunda food yarat
  lava = new PVector(int(random(w)), int(random(h)));
  
  size(1080, 720); // width and height of the window
  
  // x-y'de 50-400 eksenlerinde topların harekete başlamaları, 0-5 arası random hız belirlemek, 50-100 arasında size belirlemek
  for(int i=0; i<balls.length; i++) {
    balls[i] = new Ball((int)random(0,1080), (int)random(0,1080), (int)random(2,4), (int)random(2,4), (int)random(50,100));
  }
}

void drawFood() {
  fill(255, 0, 0); // kırmızı food  
  rect(food.x * size, food.y * size, size, size); // food'un size'ı yarattığımız snake'in size'ı ile aynı oranda olsun
}
void newFood() {
  food = new PVector(int(random(w)), int(random(h))); // x-y ekseninde random belirlensin
}

// DRAW: the block/method that runs over and over again - for any logic
void draw() {
  background(200);    
  noStroke();
   
  drawSnake();
  
  drawFood();
  
  drawNextLevelButton();
  
  // Check if the button is clicked
  if (nextLevelButtonClicked) {
    goToNextLevel();
    nextLevelButtonClicked = false; // Reset the button click state
  }

  fill(255); // beyaz olsun
  textSize(30);
  text("Score: " + score, 70, 30);
  
  updateAnimations();
  displayAnimations();
  
  rect(pos.x * size, pos.y * size, size, size);
  if (frameCount % speed == 0) {
    updateSnake();
  }
  
  if (currentLevel == 1) {
    for(int i=0; i<balls.length; i++) {
      balls[i].display();
      balls[i].update();
    }
  } else if (currentLevel == 2) { drawLava(); }
}

void drawSnake() {
  rect(pos.x * size, pos.y * size, size, size);
  for(int i = 0; i < snake.size(); i ++) {
    fill(0, 50); // gri snake
    rect(snake.get(i).x * size, snake.get(i).y * size, size, size);
  }
}
  
void updateSnake() { 
  if(dir.x != 0 || dir.y != 0) {
    snake.add(new PVector(pos.x, pos.y));
  }
  while(snake.size() > len) {
    snake.remove(0);
  }
  pos.add(dir);
 
  if(pos.x == food.x && pos.y == food.y) {
    newFood();
    len += 1;
    score += 1;
    showRedHead = true; 
    // food yediğinde snake belli bir limite kadar (2) hızlansın 
    if(speed > 2) { 
      speed = constrain(speed-1, 0, 20);
    }
  }
  
  // resets the position of the snake if the snake crashes to itself
  for(int i = 0; i < snake.size(); i++) {
    if (pos.x == snake.get(i).x && pos.y == snake.get(i).y) {
      reset();
      }
  }
  if (currentLevel == 1) {
    if(pos.x < 0) { pos.x = w - 1; }
    if(pos.x > w-1) { pos.x = 0; }
    if(pos.y < 0) { pos.y = h - 1; }
    if(pos.y > h-1) { pos.y = 0; }
  } else {
    if(pos.x < 0 || pos.x > w-1 || pos.y < 0 || pos.y > h-1) { reset(); } // diğer levellerde duvara çarpınca ölüyor
  }
}

void updateAnimations() {
    // Update red head timer
    if (showRedHead) {
        redHeadTimer--;
        if (redHeadTimer <= 0) {
            showRedHead = false;
            redHeadTimer = 60; // Reset the timer for the next time the snake eats food
        }
    }
}

void displayAnimations() {
  if (showRedHead) {
    fill(255, 0, 0); // red color for the head of the snake
    rect(pos.x * size, pos.y * size, size, size);
  }
}

void drawNextLevelButton() {
  fill(100, 200, 100); // yeşil buton
  rect(900, 20, 150, 50); // position and size of the button
  fill(255);  // beyaz yazı 
  textSize(20);
  textAlign(CENTER, CENTER);
  text("Next Level", 975, 45); 
}

void goToNextLevel() {
  // Increment the current level
  currentLevel++;
  // Reset and adjust the game for the new level
    if (currentLevel == 2) {
    reset();
    drawLava();
    
    // Initialize the second game logic here
    // Adjust game elements for the second game
    // For example, you can reset the snake and food positions  
  }
}

void colorLavaDensity() {
  colorLava += colorChangeSpeed; 
  if (colorLava <= 85 || colorLava >= 205) { // colorLava 205 olduğunda colorLava -1 loopuna düşüyor ve azalmaya başlıyor, 85 e düştüğünde ise +1 loopunda artıyor
    colorChangeSpeed *= -1; // Reverse the color change 
  }
}

void drawLava() {
  colorLavaDensity();
  fill(225, colorLava, 0); // lava turuncu olsun
  rect(lava.x * size, lava.y * size, size, size); // Lava'nın size'ı yarattığımız snake'in size'ı ile aynı oranda olsun
}

void newLava() {
  lava = new PVector(int(random(w)), int(random(h)));
}

// reset attığımızda herşey default hale dönsün
void reset() {
  speed = 20;
  len = 5;
  pos = new PVector(w/2, h/2);
  dir = new PVector(0, 0); 
  score = 0;
  snake = new ArrayList<PVector>();
}

// snake'i kontrol etmek
void keyPressed() {
  if(key == CODED) {
  if(keyCode == UP) { dir = new PVector(0, -1); }
  if(keyCode == DOWN) { dir = new PVector(0, 1); }
  if(keyCode == LEFT) { dir = new PVector(-1, 0); }
  if(keyCode == RIGHT) { dir = new PVector(1, 0); }
  }
}

void mousePressed() {
  // tıkladığın x-y ekseninde olan top renk değiştirsin
  for(int i=0; i<balls.length; i++) { // ball array'i içinde iterate et
      if(balls[i].pointInEllipse(mouseX, mouseY)) { // pointInEllipse returns "True" if point P is inside the ellipse 
        balls[i].changeColor();  
      }   
  }
  if (mouseX > 900 && mouseX < 1050 && mouseY > 20 && mouseY < 70) {
    nextLevelButtonClicked = true;
  }
}

public class Ball {
    private int x, y, dy, dx, size;
    private color ballColor = color((int)random(0,225), (int)random(0,225), (int)random(0,225));
    // we can make these public to change dx and dy, HOWEVER (in English accent) 
    // this may lead up to change variables that are not meant to change
    

    
    // processing'de başka bir file'da
    public Ball(int x, int y, int dx, int dy, int size) {
      this.x = x;
      this.y = y;
      this.dx = dx;
      this.dy = dy;
      this.size = size;
    }
    
    public void move() {
      y += dy;
      x += dx;
    }
    
    // this.dy is attribute, dy is the method
    // we need to change dx and dy
    public void setdy(int dy) {
      this.dy = dy;
    } 
    public void setdx(int dx) {
      this.dx = dx;
    }
    
    // we need to be able to see where our ball is
    public int getdy() {
      return this.dy; 
      // you can say dy but it makes it clear that you are returning this.dy
    }
    public int getdx() {
      return this.dx; 
    }
    public int getY() {
      return this.y; 
    }
    public int getX() {
      return this.x; 
    }
    public int getSize() {
      return this.size;
    }
    
    public boolean pointInEllipse(int x, int y) {
      double distance = Math.sqrt(Math.pow((x-getX()), 2) + Math.pow((y-getY()),2));
      if (distance < getSize()/2) {
        return true;
      }
      return false;
    }
    
    // 0 ile 225 arasında random bir RNGB belirleyen metod
    public void changeColor() {
       this.ballColor = color((int)random(0,225), (int)random(0,225), (int)random(0,225));
    }
    
    public boolean isCollidingVerticalWalls() {
      if(getX()-(getSize()/2) < 0 || getX()+(getSize()/2) > width) {
      return true; 
    }
    return false;
  } 
    public boolean isCollidingHorizontalWalls() {
    if(getY()-(getSize()/2) < 0 || getY()+(getSize()/2) > height) {
      return true; 
    }
    return false;
  } 
    
    public void checkCollision() {
      if(isCollidingHorizontalWalls()) {
        setdy( getdy() * -1);
        // dy *= -1;
      }   
      if(isCollidingVerticalWalls()) {
        setdx( getdx() * -1);
        // dx *= -1;
      }
    }
    
    public void update() {
      move();
      checkCollision();
    }
    
    public void display() {
      fill(red(ballColor), green(ballColor), blue(ballColor), 50);
      ellipse(x, y, size * 4, size * 4); // x, y, width, height
      }
  } 