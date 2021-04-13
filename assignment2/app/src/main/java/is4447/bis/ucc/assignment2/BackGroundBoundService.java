package is4447.bis.ucc.assignment2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

/**
 /**
 * Created by Michael Gleeson on 18/02/2021
 * Copyright (c) 2021 | gleeson.io
 */

public class BackGroundBoundService extends Service {
    public BackGroundBoundService() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return new BackGroundBinder();
    }

    public class BackGroundBinder extends Binder {

        private ThreadGroup myThreadGroup = new ThreadGroup("Beer");

        //Binder methods go in here, these are specific
        //to our implementation. Any public methods will
        //make up the interface to the bound service

        public void getMeABeer(final int beerId, final Handler h) {

            new Thread(myThreadGroup, new Runnable() {

                @Override
                public void run() {

                    //Do background stuff here.
           //         Hero b = HeroAdapter.getHeroes();
                    Message m = new Message();
              //      m.obj = b;
                    h.sendMessage(m);

                }//end run()

            }).start();

        }//end getMeABeer()

    }//end BackGroundBinder class

}
