package hnp.Want2Sgare;


import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Button;




public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the
     * three primary sections of the app. We use a {@link android.support.v4.app.FragmentPagerAdapter}
     * derivative, which will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;
    /**
     * The {@link ViewPager} that will display the three primary sections of the app, one at a
     * time.
     */
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Global.sOut="Submitted Successfully";
        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();

        // Specify that the Home/Up button should not be enabled, since there is no hierarchical
        // parent.
        actionBar.setHomeButtonEnabled(false);

        // Specify that we will be displaying tabs in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set up the ViewPager, attaching the adapter and setting up a listener for when the
        // user swipes between sections.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When swiping between different app sections, select the corresponding tab.
                // We can also use ActionBar.Tab#select() to do this if we have a reference to the
                // Tab.
                actionBar.setSelectedNavigationItem(position);
            }
        });


        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by the adapter.
            // Also specify this Activity object, which implements the TabListener interface, as the
            // listener for when this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mAppSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
    }


    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
        int i = tab.getPosition();
       /* if (i==1){

                Intent intent = new Intent(this, TransList.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Intent externalActivityIntent = new Intent(Intent.ACTION_PICK);
        externalActivityIntent.setType("image/*");
        externalActivityIntent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        startActivity(externalActivityIntent);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
     * sections of the app.
     */
    public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    // The first section of the app is the most interesting -- it offers
                    // a launchpad into the other demonstrations in this example application.
                    return new LaunchpadSectionFragment();

                default:
                    // The other sections of the app are dummy placeholders.
                    Fragment fragment = new SectionFragment();
                    Bundle args = new Bundle();
                    args.putInt(SectionFragment.ARG_SECTION_NUMBER, i + 1);
                    fragment.setArguments(args);
                    return fragment;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //return "Section " + (position + 1);
            /*if (position+1 == 1)
            {
                return "Dashboard";
            }
            else
                return "Section " + (position + 1); */
            switch (position + 1) {
                case 1:
                    return "DASHBOARD";
                case 2:
                    return "TRANSACTIONS";
                case 3:
                    return "SHARE";

            }
            return "Section " + (position + 1);
        }
    }

    /**
     * A fragment that launches other parts of the demo application.
     */
    public static class LaunchpadSectionFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section_launchpad, container, false);

            // Demonstration of a collection-browsing activity.
            rootView.findViewById(R.id.demo_collection_button)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new Intent(getActivity(), CollectionDemoActivity.class);
                            startActivity(intent);
                        }
                    });

            return rootView;
        }
    }



    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     *
     */
    public static class SectionFragment extends Fragment {

        public static final String ARG_SECTION_NUMBER = "section_number";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_section, container, false);

            Bundle args = getArguments();
            if (args.getInt(ARG_SECTION_NUMBER) == 2) {
                rootView.findViewById(R.id.btTransList)
                        .setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(getActivity(), TransList.class);
                                startActivity(intent);

                            }
                        });

                return rootView;
            }
            else
            /*else {
                ((TextView) rootView.findViewById(android.R.id.text1)).setText("Share Page");
            }*/

             {
                View rootView1 = inflater.inflate(R.layout.fragment_section2,container,false);

                 rootView1.findViewById(R.id.image_activity)
                         .setOnClickListener(new View.OnClickListener() {


                             @Override
                             public void onClick(View view) {
                                 //((TextView) view.findViewById(android.R.id.text2)).setText("Share Page");


                                 //Global.arrRec = Global.arrRec+1;
                                 Intent intent = new Intent(getActivity(), ActivityMessage.class);
                                 startActivity(intent);

                             }
                         });
                //((TextView) rootView.findViewById(android.R.id.text1)).setText("Share Page");
                return rootView1;
            }

        }


    }

}

