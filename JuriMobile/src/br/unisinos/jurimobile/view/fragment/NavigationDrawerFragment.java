package br.unisinos.jurimobile.view.fragment;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import br.unisinos.jurimobile.R;
import br.unisinos.jurimobile.controller.ProcessoListActivity;
import br.unisinos.jurimobile.model.entity.Grupo;
import br.unisinos.jurimobile.view.adapter.DrawerMenuGruposAdapter;

public class NavigationDrawerFragment extends Fragment {

	private static final String TAG = NavigationDrawerFragment.class.getSimpleName();

	private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

	private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

	protected Context context;
	protected Activity activity;
	private ListView drawerList;
	private int currentPosition;
	private View mFragmentContainerView;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private boolean mUserLearnedDrawer;
	private boolean mFromSavedInstanceState;
	
	private List<Grupo> grupos;
	private FragmentCallBack fragmentCallBack;

	public NavigationDrawerFragment() {
		super();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = activity;
		this.context = activity.getApplicationContext();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		activity = null;
		context = null;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		drawerList = (ListView) inflater.inflate(R.layout.fragment_drawer_menu, container, false);
		
		loadListeners();
		loadView();

		return drawerList;
	}

	private void loadView() {
		grupos = ProcessoListActivity.getGruposMock();
		if (grupos != null) {
			DrawerMenuGruposAdapter drawerMenuAdapter = new DrawerMenuGruposAdapter(context, grupos);

			drawerList.setAdapter(drawerMenuAdapter);
			drawerList.setItemChecked(currentPosition, true);
		}
	}
	
	public void setUp(int fragmentId, DrawerLayout drawerLayout, Toolbar toolBar) {
		try {

			mFragmentContainerView = getActivity().findViewById(fragmentId);
			mDrawerLayout = drawerLayout;

			// set a custom shadow that overlays the main content when the
			// drawer opens
			mDrawerLayout.setDrawerShadow(R.drawable.ic_drawer_menu_shadow, GravityCompat.START);
			// set up the drawer's list view with items and click listener

			// ActionBarDrawerToggle ties together the the proper interactions
			// between the navigation drawer and the action bar app icon.
			mDrawerToggle = new ActionBarDrawerToggle(getActivity(), /*
																	 * host
																	 * Activity
																	 */
			mDrawerLayout, /* DrawerLayout object */
			toolBar,
			R.string.app_name, /* "open drawer" description for accessibility */
			R.string.app_name /* "close drawer" description for accessibility */
			) {

				@Override
				public void onDrawerClosed(View drawerView) {
					super.onDrawerClosed(drawerView);
					if (!isAdded()) {
						return;
					}

					getActivity().supportInvalidateOptionsMenu(); // calls
																	// onPrepareOptionsMenu()
				}

				@Override
				public void onDrawerOpened(View drawerView) {
					super.onDrawerOpened(drawerView);
					if (!isAdded()) {
						return;
					}

					if (!mUserLearnedDrawer) {
						// The user manually opened the drawer; store this flag
						// to prevent auto-showing
						// the navigation drawer automatically in the future.
						mUserLearnedDrawer = true;
						// SharedPreferences sp =
						// PreferenceManager.getDefaultSharedPreferences(getActivity());
						// sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER,
						// true).apply();
					}

					getActivity().supportInvalidateOptionsMenu(); // calls
																	// onPrepareOptionsMenu()
				}
			};

			// If the user hasn't 'learned' about the drawer, open it to
			// introduce them to the drawer,
			// per the navigation drawer design guidelines.
			// if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
			// mDrawerLayout.openDrawer(mFragmentContainerView);
			// }

			// Defer code dependent on restoration of previous instance state.
			mDrawerLayout.post(new Runnable() {
				@Override
				public void run() {
					mDrawerToggle.syncState();
				}
			});

			mDrawerLayout.setDrawerListener(mDrawerToggle);

		} catch (Exception e) {
			Log.e(TAG, "Error LoadFragment", e);
			throw e;
		}
	}

	public boolean isDrawerOpen() {
		return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			if (mDrawerLayout != null) {
				if (isDrawerOpen()) {
					mDrawerLayout.closeDrawer(mFragmentContainerView);
				} else {
					mDrawerLayout.openDrawer(mFragmentContainerView);
				}
			} else {
				getActivity().finish();
			}
		}
		return super.onOptionsItemSelected(item);
	}

	private void loadListeners() {
		drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				selectItem(position);
			}
		});
	}

	private void selectItem(int position) {
		currentPosition = position;
		
		if (drawerList != null) {
			drawerList.setItemChecked(position, true);
		}
		
		if (fragmentCallBack != null) {
			fragmentCallBack.onSelectedItem(position);
		}
		
		if (mDrawerLayout != null) {
			mDrawerLayout.closeDrawer(mFragmentContainerView);
		}
		 
	}
	
	public void registerCallBack(FragmentCallBack fragmentCallBack){
		this.fragmentCallBack = fragmentCallBack;
	}

	/*
	 * @Override public void onDetach() { super.onDetach(); mCallbacks = null; }
	 */

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(STATE_SELECTED_POSITION, currentPosition);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Forward the new configuration the drawer toggle component.
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

}
