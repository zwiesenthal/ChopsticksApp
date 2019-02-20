//Zach Wiesenthal
package com.chop.zwies.chopsticks;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Interpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView begin;
    TextView turner;
    Button startGame;
    Button br;
    Button bl;
    Button tr;
    Button tl;
    Button restart;

    LinearLayout[] lastClicked = null;

    int toprighthand = 1;
    int toplefthand = 1;
    int botrighthand = 1;
    int botlefthand= 1;

    int turn = 0;
    int turns = 0;

    LinearLayout tl1;
    LinearLayout tl2;
    LinearLayout tl3;
    LinearLayout tl4;
    LinearLayout tl5;
    LinearLayout tr1;
    LinearLayout tr2;
    LinearLayout tr3;
    LinearLayout tr4;
    LinearLayout tr5;
    LinearLayout bl1;
    LinearLayout bl2;
    LinearLayout bl3;
    LinearLayout bl4;
    LinearLayout bl5;
    LinearLayout br1;
    LinearLayout br2;
    LinearLayout br3;
    LinearLayout br4;
    LinearLayout br5;

    LinearLayout[] tlh = new LinearLayout[5];
    LinearLayout[] trh = new LinearLayout[5];
    LinearLayout[] blh = new LinearLayout[5];
    LinearLayout[] brh = new LinearLayout[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        startGame = (Button)findViewById(R.id.btnStart);
        begin = (TextView)findViewById(R.id.textView);
        turner = (TextView)findViewById(R.id.tvTurn);
        turner.setY(1250);
        bl = (Button)findViewById(R.id.btnBotLeft);
        br = (Button)findViewById(R.id.btnBotRight);
        tl = (Button)findViewById(R.id.btnTopLeft);
        tr = (Button)findViewById(R.id.btnTopRight);

        restart = (Button)findViewById(R.id.tart);

        tl1 = (LinearLayout)findViewById(R.id.tl1);
        tl2 = (LinearLayout)findViewById(R.id.tl2);
        tl3 = (LinearLayout)findViewById(R.id.tl3);
        tl4 = (LinearLayout)findViewById(R.id.tl4);
        tl5 = (LinearLayout)findViewById(R.id.tl5);
        tr1 = (LinearLayout)findViewById(R.id.tr1);
        tr2 = (LinearLayout)findViewById(R.id.tr2);
        tr3 = (LinearLayout)findViewById(R.id.tr3);
        tr4 = (LinearLayout)findViewById(R.id.tr4);
        tr5 = (LinearLayout)findViewById(R.id.tr5);
        bl1 = (LinearLayout)findViewById(R.id.bl1);
        bl2 = (LinearLayout)findViewById(R.id.bl2);
        bl3 = (LinearLayout)findViewById(R.id.bl3);
        bl4 = (LinearLayout)findViewById(R.id.bl4);
        bl5 = (LinearLayout)findViewById(R.id.bl5);
        br1 = (LinearLayout)findViewById(R.id.br1);
        br2 = (LinearLayout)findViewById(R.id.br2);
        br3 = (LinearLayout)findViewById(R.id.br3);
        br4 = (LinearLayout)findViewById(R.id.br4);
        br5 = (LinearLayout)findViewById(R.id.br5);

        initiate();
        setHand(tlh, 1);
        setHand(trh, 1);
        setHand(blh, 1);
        setHand(brh, 1);

    }

    public void initiate(){
        tlh[0] = tl1;
        tlh[1] = tl2;
        tlh[2] = tl3;
        tlh[3] = tl4;
        tlh[4] = tl5;
        trh[0] = tr1;
        trh[1] = tr2;
        trh[2] = tr3;
        trh[3] = tr4;
        trh[4] = tr5;
        blh[0] = bl1;
        blh[1] = bl2;
        blh[2] = bl3;
        blh[3] = bl4;
        blh[4] = bl5;
        brh[0] = br1;
        brh[1] = br2;
        brh[2] = br3;
        brh[3] = br4;
        brh[4] = br5;
    }

    public void BRClicked(View v){
        if(botrighthand != 0) {
            if (turn == 0) {
                bl.setBackgroundColor(Color.TRANSPARENT);
                if (lastClicked != brh) {
                    lastClicked = brh;
                    br.setBackgroundResource(R.drawable.borderbutton);
                } else {
                    lastClicked = null;
                    br.setBackgroundColor(Color.TRANSPARENT);
                }
            }
            else {
                if (lastClicked == trh){
                    tr.setBackgroundColor(Color.TRANSPARENT);
                    int total = toprighthand + botrighthand;
                    total = total%5;
                    setHand(brh, total);
                    nextTurn();
                }
                else if (lastClicked == tlh){
                    tl.setBackgroundColor(Color.TRANSPARENT);
                    int total = toplefthand + botrighthand;
                    total = total%5;
                    setHand(brh, total);
                    nextTurn();
                }
            }
        }
        else if(botlefthand%2==0){
            setHand(brh,botlefthand/2);
            setHand(blh,botlefthand/2);
            nextTurn();
            bl.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    public void TRClicked(View v){
        if(toprighthand != 0) {
            if (turn == 1) {
                tl.setBackgroundColor(Color.TRANSPARENT);
                if (lastClicked != trh) {
                    lastClicked = trh;
                    tr.setBackgroundResource(R.drawable.borderbutton);
                } else {
                    lastClicked = null;
                    tr.setBackgroundColor(Color.TRANSPARENT);
                }
            }
            else {
                if (lastClicked == brh){
                    br.setBackgroundColor(Color.TRANSPARENT);
                    int total = botrighthand + toprighthand;
                    total = total%5;
                    setHand(trh, total);
                    nextTurn();
                }
                else if (lastClicked == blh){
                    bl.setBackgroundColor(Color.TRANSPARENT);
                    int total = botlefthand + toprighthand;
                    total = total%5;
                    setHand(trh, total);
                    nextTurn();
                }
            }
        }
        else if(toplefthand%2==0){
            setHand(trh,toplefthand/2);
            setHand(tlh,toplefthand/2);
            nextTurn();
            tl.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    public void TLClicked(View v){
        if(toplefthand != 0) {
            if (turn == 1) {
                tr.setBackgroundColor(Color.TRANSPARENT);
                if (lastClicked != tlh) {
                    lastClicked = tlh;
                    tl.setBackgroundResource(R.drawable.borderbutton);
                } else {
                    lastClicked = null;
                    tl.setBackgroundColor(Color.TRANSPARENT);
                }
            }
            else {
                if (lastClicked == brh){
                    br.setBackgroundColor(Color.TRANSPARENT);
                    int total = botrighthand + toplefthand;
                    total = total%5;
                    setHand(tlh, total);
                    nextTurn();
                }
                else if (lastClicked == blh){
                    bl.setBackgroundColor(Color.TRANSPARENT);
                    int total = botlefthand + toplefthand;
                    total = total%5;
                    setHand(tlh, total);
                    nextTurn();
                }
            }
        }
        else if(toprighthand%2==0){
            setHand(tlh,toprighthand/2);
            setHand(trh,toprighthand/2);
            nextTurn();
            tr.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    public void BLClicked(View v){
        if(botlefthand != 0) {
            if (turn == 0) {
                br.setBackgroundColor(Color.TRANSPARENT);
                if (lastClicked != blh) {
                    lastClicked = blh;
                    bl.setBackgroundResource(R.drawable.borderbutton);
                } else {
                    lastClicked = null;
                    bl.setBackgroundColor(Color.TRANSPARENT);
                }
            }
            else {
                if (lastClicked == trh){
                    tr.setBackgroundColor(Color.TRANSPARENT);
                    int total = toprighthand + botlefthand;
                    total = total%5;
                    setHand(blh, total);
                    nextTurn();
                }
                else if (lastClicked == tlh){
                    tl.setBackgroundColor(Color.TRANSPARENT);
                    int total = toplefthand + botlefthand;
                    total = total%5;
                    setHand(blh, total);
                    nextTurn();
                }
            }
        }
        else if(botrighthand%2==0){
            setHand(blh,botrighthand/2);
            setHand(brh,botrighthand/2);
            nextTurn();
            br.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    public void setHand(LinearLayout[] hand, int n){
        if(hand == brh){botrighthand=n;}
        if(hand == trh){toprighthand=n;}
        if(hand == blh){botlefthand=n;}
        if(hand == tlh){toplefthand=n;}

        for (int i = 0; i < n; i++){
            hand[i].setVisibility(View.VISIBLE);
        }
        for (int i = n; i < 5; i++){
            hand[i].setVisibility(View.INVISIBLE);
        }
        if (toplefthand + toprighthand == 0){
            endGame();
            startGame.setText("Bottom Player Wins");
        }
        else if (botrighthand + botlefthand == 0){
            endGame();
            startGame.setText("Top Player Wins");
        }
    }
    public void nextTurn(){
        turn +=1;
        turn = turn%2;
        turns++;
        turner.setText("Turn: " + turns);
        if(turn == 0){
            turner.setY(1250);
        }
        else {
            turner.setY(950);
        }

    }

    public int aiTurn(int player, ArrayList<Integer> myHands, ArrayList<Integer> yourHands,ArrayList<ArrayList<ArrayList<Integer>>> previous){
        //myHands would be like {1,3} if one of my hands had 1 fingers and the other had 3
        //player -1 is first, player 1 is second
        for (int i =0;i<yourHands.size();i++){
            if (yourHands.get(i)==0){
                yourHands.remove(i);
            }
        }
        for (int i =0;i<myHands.size();i++){
            if (myHands.get(i)==0){
                myHands.remove(i);
            }
        }
        //baseCASE
        if (myHands.size() == 0){
            return(player);
        }
        else if (yourHands.size() == 0){
            return(player*-1);
        }
        for (int i = 0; i <previous.size();i++){
            if(previous.size()>1){
                if (previous.get(previous.size()-1)== previous.get(i)){
                    return 0;
                }
            }
        }
        //not base case

        //add current board state to previous, before changing it
        ArrayList<Integer> pmh= new ArrayList<>(myHands);
        ArrayList<Integer> pyh= new ArrayList<>(yourHands);
        ArrayList<ArrayList<Integer>> both = new ArrayList<>();
        both.add(pmh);
        both.add(pyh);
        previous.add(both);

        ArrayList<Integer> options = new ArrayList<>();

        for (int i = 0; i < myHands.size(); i++){
            for (int j = 0; j < yourHands.size(); j++){
                ArrayList<Integer> tempmh = new ArrayList<>(myHands);
                ArrayList<Integer> tempyh = new ArrayList<>(yourHands);
                tempyh.set(j, (tempyh.get(j)+tempmh.get(i))%5);
                options.add(aiTurn(player*-1, tempyh, tempmh, previous));
            }
        }
        int temp = options.get(0);
        if(player==-1) {
            for (int i = 0; i < options.size(); i++) {
                if (options.get(i) > temp) {
                    temp = options.get(i);

                }
            }
        }
        if(player==1) {
            for (int i = 0; i < options.size(); i++) {
                if (options.get(i) < temp) {
                    temp = options.get(i);

                }
            }
        }
        return temp;
        //return maximum of options list


    }
    public void aigo(View v){
        ArrayList<Integer> myhands= new ArrayList<>();
        myhands.add(toplefthand);
        myhands.add(toprighthand);
        ArrayList<Integer> yourhands = new ArrayList<>();
        yourhands.add(botlefthand);
        yourhands.add(botrighthand);

        ArrayList<ArrayList<ArrayList<Integer>>> both = new ArrayList<>();

        //System.out.println(aiTurn(1,myhands,yourhands,both));
        int output = aiTurn(1,myhands,yourhands,both);
        if(output == 0){
            ArrayList<Integer> tom = new ArrayList<>();
            //tom.add(0, 0);
            tom.add(4);
            ArrayList<Integer> jerry = new ArrayList<>();
            jerry.add(1);
            //jerry.add(1, 0);
            System.out.println("test  " + aiTurn(-1,tom,jerry,both));
            System.out.println("bread0");
            boolean stop = false;
            if(toplefthand!=0 && botlefthand!=0){
                ArrayList<Integer> pyh= new ArrayList<>(yourhands);
                pyh.set(0, (toplefthand+botlefthand)%5);

                if (aiTurn(-1,myhands,pyh,both) == 0){
                    stop = true;
                    TLClicked(v);
                    BLClicked(v);
                }
            }
            if (!stop && toplefthand!=0 && botrighthand!=0){
                ArrayList<Integer> pyh= new ArrayList<>(yourhands);
                pyh.set(1, (toplefthand+botrighthand)%5);

                if (aiTurn(-1,myhands,pyh,both) == 0){
                    stop = true;
                    TLClicked(v);
                    BRClicked(v);
                }
            }
            if (!stop && toprighthand!=0 && botlefthand!=0){
                ArrayList<Integer> pyh= new ArrayList<>(yourhands);
                pyh.set(0, (toprighthand+botlefthand)%5);

                if (aiTurn(-1,myhands,pyh,both) == 0){
                    stop = true;
                    TRClicked(v);
                    BLClicked(v);
                }
            }
            if (!stop && toprighthand!=0 && botrighthand!=0){
                ArrayList<Integer> pyh= new ArrayList<>(yourhands);
                pyh.set(1, (toprighthand+botrighthand)%5);

                if (aiTurn(-1,myhands,pyh,both) == 0){
                    stop = true;
                    TRClicked(v);
                    BRClicked(v);
                }
            }
        }
        else if(output == -1){
            System.out.println("potato-1");
            boolean stop = false;
            if(toplefthand!=0 && botlefthand!=0){
                ArrayList<Integer> pyh= new ArrayList<>(yourhands);
                pyh.set(0, (toplefthand+botlefthand)%5);
                if (aiTurn(-1,myhands,pyh,both) == -1){
                    stop = true;
                    TLClicked(v);
                    BLClicked(v);
                }
            }
            if (!stop && toplefthand!=0 && botrighthand!=0){
                ArrayList<Integer> pyh= new ArrayList<>(yourhands);
                pyh.set(1, (toplefthand+botrighthand)%5);
                if (aiTurn(-1,myhands,pyh,both) == -1){
                    stop = true;
                    TLClicked(v);
                    BRClicked(v);
                }
            }
            if (!stop && toprighthand!=0 && botlefthand!=0){
                ArrayList<Integer> pyh= new ArrayList<>(yourhands);
                pyh.set(0, (toprighthand+botlefthand)%5);
                if (aiTurn(-1,myhands,pyh,both) == -1){

                    stop = true;
                    TRClicked(v);
                    BLClicked(v);
                }
            }
            if (!stop && toprighthand!=0 && botrighthand!=0){
                ArrayList<Integer> pyh= new ArrayList<>(yourhands);
                pyh.set(1, (toprighthand+botrighthand)%5);
                if (aiTurn(-1,myhands,pyh,both) == -1){
                    stop = true;
                    TRClicked(v);
                    BRClicked(v);
                }
            }

        }
        else{
            System.out.println("Sponge1");
            boolean stop = false;
            if(toplefthand!=0 && botlefthand!=0){
                System.out.println("TestCase1");
                ArrayList<Integer> pyh= new ArrayList<>(yourhands);
                pyh.set(0, (toplefthand+botlefthand)%5);
                System.out.println("bypass1");
                if (aiTurn(-1,myhands,pyh,both) == 1){
                    System.out.println("wincase1");
                    stop = true;
                    TLClicked(v);
                    BLClicked(v);
                }
            }
            if (!stop && toplefthand!=0 && botrighthand!=0){
                System.out.println("TestCase2");
                ArrayList<Integer> pyh= new ArrayList<>(yourhands);
                pyh.set(1, (toplefthand+botrighthand)%5);
                System.out.println("bypass2");
                if (aiTurn(-1,myhands,pyh,both) == 1){
                    System.out.println("wincase2");
                    stop = true;
                    TLClicked(v);
                    BRClicked(v);
                }
            }
            if (!stop && toprighthand!=0 && botlefthand!=0){
                System.out.println("TestCase3");
                ArrayList<Integer> pyh= new ArrayList<>(yourhands);
                pyh.set(0, (toprighthand+botlefthand)%5);
                System.out.println((toprighthand+botlefthand)%5);
                System.out.println("bypass3 " + aiTurn(-1,myhands,pyh,both));

                if (aiTurn(-1,myhands,pyh,both) == 1){
                    System.out.println("wincase3");
                    stop = true;
                    TRClicked(v);
                    BLClicked(v);
                }
            }
            if (!stop && toprighthand!=0 && botrighthand!=0){
                System.out.println("TestCase4");
                ArrayList<Integer> pyh= new ArrayList<>(yourhands);
                pyh.set(1, (toprighthand+botrighthand)%5);
                System.out.println("bypass4 " + aiTurn(-1,myhands,pyh,both));

                if (aiTurn(-1,myhands,pyh,both) == 1){
                    System.out.println("wincase4");
                    stop = true;
                    TRClicked(v);
                    BRClicked(v);
                }
            }
            System.out.println("TestCaseAlert");
        }

        turner.setText("Wants to go to: " + aiTurn(1,myhands,yourhands,both));
    }

    //not necessary, but better than having a seperate variable
    public int getLength(LinearLayout[] hand){
        int total = 0;
        for (int i = 0; i < hand.length; i++){
            if (hand[i].getVisibility() == View.VISIBLE){
                total++;
            }
        }
        return total;
    }

    public void endGame(){
        startGame.setVisibility(View.VISIBLE);
        restart.setVisibility(View.VISIBLE);
    }
    public void restarted(View v){
        setHand(blh,1);
        setHand(brh,1);
        setHand(tlh,1);
        setHand(trh,1);
        startGame.setVisibility(View.GONE);
        restart.setVisibility(View.GONE);
        turn = 0;
        turns =0;
        turner.setText("Turn: " + turns);
        lastClicked = null;
    }
    public void BeginGame(View v){
        begin.setVisibility(View.INVISIBLE);
    }
}
