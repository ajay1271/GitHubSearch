package cavepass.com.githubsearch;


import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private IdlingResource mIdlingResource;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void registerIdlingResource() {

        mIdlingResource = mActivityTestRule.getActivity().getIdlingResource();

        IdlingRegistry.getInstance().register(mIdlingResource);

        // Espresso.registerIdlingResource(countingResource);

    }


    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.edit_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.input_layout_name),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("tom"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.edit_text), withText("tom"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.input_layout_name),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.edit_text), withText("tom"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.input_layout_name),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("tomt"));

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.edit_text), withText("tomt"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.input_layout_name),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText4.perform(closeSoftKeyboard());

        ViewInteraction linearLayout = onView(
                allOf(withId(R.id.search_button),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        linearLayout.perform(click());

        ViewInteraction relativeLayout = onView(
                allOf(withId(R.id.search_result_box),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.list),
                                        0),
                                0)));
        relativeLayout.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.edit_text), withText("tomt"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.input_layout_name),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText5.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.edit_text), withText("tomt"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.input_layout_name),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("ajay"));

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.edit_text), withText("ajay"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.input_layout_name),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText7.perform(closeSoftKeyboard());

        ViewInteraction linearLayout2 = onView(
                allOf(withId(R.id.search_button),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        0),
                                1),
                        isDisplayed()));
        linearLayout2.perform(click());

        ViewInteraction relativeLayout2 = onView(
                allOf(withId(R.id.search_result_box),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.list),
                                        0),
                                0)));
        relativeLayout2.perform(scrollTo(), click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
