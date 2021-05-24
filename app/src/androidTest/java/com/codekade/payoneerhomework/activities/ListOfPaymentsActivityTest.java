package com.codekade.payoneerhomework.activities;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;

import com.codekade.payoneerhomework.R;

import org.junit.Rule;
import org.junit.Test;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@LargeTest
public class ListOfPaymentsActivityTest {

    @Rule
    public ActivityScenarioRule<ListOfPaymentsActivity> listOfPaymentsActivity = new ActivityScenarioRule<>(ListOfPaymentsActivity.class);

    @Test
    public void testSample(){
        //if (getRVcount() > 0){
            onView(withId(R.id.recycler_payment_methods)).perform((androidx.test.espresso.ViewAction) RecyclerViewActions.actionOnItemAtPosition(0, (ViewAction) click()));
        //}
    }

//    private int getRecyclerViewCount(){
//        RecyclerView recyclerView = (RecyclerView) mActivityRule.getActivity().findViewById(R.id.our_recycler_view);
//        return recyclerView.getAdapter().getItemCount();
//    }

}