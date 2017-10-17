
var playing = false;   //at the beginning, we are not playing this game
var score; //current score for this game.
var action;
var timeremaining; //how much time does the user remain.
var correctAnswer; //the correct answer of each question.
// if we click on the start/reset button
document.getElementById("startreset").onclick = function()
{
    if(playing == true)//if we are playing
        {
           location.reload();//reload the page 
        }
    else //if we are not playing
    {
        playing = true;   //change the status to playing  
        score = 0;//set score to 0
        document.getElementById("scorevalue").innerHTML = score;
        
        //show countdown box
        show("timeremaining");
        timeremaining = 60;
        document.getElementById("timeremainingvalue").innerHTML = timeremaining;
        
        //hide the game over box
        hide("gameOver");
        
        //then countdown begins
        startCountdown();
        
        //change button to reset
        document.getElementById("startreset").innerHTML = "Reset Game";
        
        //generate new Q&A
        generateQA();
        
        
    }  
     
        
}
    

//clicking on an answer box
for(i = 1; i < 5; i++)
    {
        document.getElementById("box" + i).onclick = function()
{
    //check if we are playing
    if(playing == true)
        {
            //check if answer is correct.
            if(this.innerHTML == correctAnswer)
                {
                    //correct answer
                    score++;
                    document.getElementById("scorevalue").innerHTML = score;
                    //show the correct box and hide the wrong box
                    hide("wrong");
                    show("correct");
                    setTimeout(function(){
                        hide("correct");
                    }, 1000);
                    
                    //generate a new question
                    generateQA();
                }
            else  //wrong answer
                {
                    hide("correct");
                    show("wrong");
                    setTimeout(function(){
                        hide("wrong");
                    }, 1000);
                }
        }
}
    }
        
        
        
        





    //if we are playing
        //correct?
            //yes
                //increase score
                //show correct box for 1 sec
                //generate new Q&A
            //no
                //show try again box for 1 sec


//-----------------------------------------------------------------------------
//functions
//start countdown functionality
function startCountdown()
{
    action = setInterval(function(){
        //reduce time by 1 sec in loops
        timeremaining -= 1;
        
            
        document.getElementById("timeremainingvalue").innerHTML = timeremaining;
        if(timeremaining == 0) //countdown is over : time remaining == 0;
            {
                //time left?
                    //yes -> continue
                    //no -> game over
                stopCountdown();
                show("gameOver");
                document.getElementById("gameOver").innerHTML = "<p>Game over!</p><p>Your score is :" + score + ".</p>";
                hide("timeremaining"); 
                hide("correct");
                hide("wrong");
                playing = false;
                document.getElementById("startreset").innerHTML = "Start Game";
            }
            
    }, 1000);
}

//stop countdown functionality
function stopCountdown()
{
    clearInterval(action);
}

//hide an element
function hide(Id)
{
    document.getElementById(Id).style.display = "none";
}

//show an element
function show(Id)
{
    document.getElementById(Id).style.display = "block";
}

//generate a new question and answers
function generateQA()
{
    var x = 1 + Math.round(9 * Math.random());
    var y = 1 + Math.round(9 * Math.random());
    correctAnswer = x*y;
    document.getElementById("question").innerHTML = x + "X" + y;
    var correctPosition = 1 + Math.round(3 * Math.random()); //the correct position of correct answer
    document.getElementById("box" + correctPosition).innerHTML = correctAnswer; //fill in the correct answer
    
    //then fill other boxes with wrong answers
    
    var answers = [correctAnswer];
    
    for(i = 1; i < 5; i++)
        {
            if(i != correctPosition)
                {
                    var wrongAnswer;
                    do
                        {
                            wrongAnswer = (1 + Math.round(9 * Math.random()))*(1 + Math.round(9 * Math.random()));
                        }while(answers.indexOf(wrongAnswer)>-1)
                    document.getElementById("box" + i).innerHTML = wrongAnswer;
                    answers.push(wrongAnswer);
                }
        }
}