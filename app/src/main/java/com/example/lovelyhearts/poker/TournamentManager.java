package com.example.lovelyhearts.poker;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Lovelyhearts on 5/5/2015.
 */
public class TournamentManager {

    private static List<Tournament> tournaments;

    public TournamentManager() {
        tournaments = new ArrayList<Tournament>();
        Tournament t1 = new Tournament();

        t1.setLocation("Corner bar");
        t1.setTime("8PM");
        t1.setDate("5/10/2015`");
        t1.setWeek("Friday");
        t1.setBuyIn(10);


        Tournament t2 = new Tournament();
        t2.setLocation("CrabShack");
        t2.setTime("9PM");
        t2.setDate("4/13/2015`");
        t2.setWeek("Monday");
        t2.setBuyIn(10);

        tournaments.add(t1);
        tournaments.add(t2);
    }
    public Tournament GetTournament(String mId)
    {
        try {
            return getTournamentByLocation(mId);
        }
        catch (Exception ex) {
            Log.w("GetContact", "No Contact with id=[" + mId + "]");
            return null;
        }
    }

    public Tournament getTournamentByLocation(String location) throws TournamentNotFoundException {
        Iterator<Tournament> itr = tournaments.iterator();

        while (itr.hasNext()) {
            Tournament curr = itr.next();
            if (curr.getLocation().equals(location)) {
                return curr;
            }
        }
        throw new TournamentNotFoundException("Exception: No contact found with id [" + location + "]");
    }

    private class TournamentNotFoundException extends Exception {
        public TournamentNotFoundException(String msg) {
            super(msg);
        }
    }
}

