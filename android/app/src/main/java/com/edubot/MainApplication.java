package com.edubot;

import android.app.Application;
import android.content.Context;

import com.facebook.react.ReactApplication;
import com.johnsonsu.rnsoundplayer.RNSoundPlayerPackage;
import com.zmxv.RNSound.RNSoundPackage;
import com.rnim.rn.audio.ReactNativeAudioPackage;
import com.imagepicker.ImagePickerPackage;
import com.rnfs.RNFSPackage;
import de.innfactory.apiai.RNApiAiPackage;

import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;
import io.invertase.firebase.firestore.ReactNativeFirebaseFirestorePackage;

import com.facebook.reactnative.androidsdk.FBSDKPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.oblador.vectoricons.VectorIconsPackage;
import com.th3rdwave.safeareacontext.SafeAreaContextPackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import org.devio.rn.splashscreen.SplashScreenReactPackage;

import com.reactnativecommunity.asyncstorage.AsyncStoragePackage;

import io.invertase.firebase.database.ReactNativeFirebaseDatabasePackage;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import com.facebook.reactnative.androidsdk.FBSDKPackage;

import co.apptailor.googlesignin.RNGoogleSigninPackage;  // <--- import
import com.reactnativecommunity.cameraroll.CameraRollPackage;

public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost =
            new ReactNativeHost(this) {
                @Override
                public boolean getUseDeveloperSupport() {
                    return BuildConfig.DEBUG;
                }

                @Override
                protected List<ReactPackage> getPackages() {
                    return Arrays.<ReactPackage>asList(
                            new MainReactPackage(),
            new RNSoundPlayerPackage(),
            new RNSoundPackage(),
            new ReactNativeAudioPackage(),
            new ImagePickerPackage(),
            new RNFSPackage(),
            new RNApiAiPackage(),
                            new ReactNativeFirebaseDatabasePackage(),
                            new ReactNativeFirebaseAppPackage(),
                            new ReactNativeFirebaseFirestorePackage(),
                            new ReanimatedPackage(),
                            new VectorIconsPackage(),
                            new SafeAreaContextPackage(),
                            new RNGestureHandlerPackage(),
                            new FBSDKPackage(),
                            new RNGoogleSigninPackage(),
                            new SplashScreenReactPackage(), // <-- this needs to be in the list
                            new AsyncStoragePackage(),
                            new CameraRollPackage()
                    );
                }

                @Override
                protected String getJSMainModuleName() {
                    return "index";
                }
            };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        SoLoader.init(this, /* native exopackage */ false);
        initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
    }

    /**
     * Loads Flipper in React Native templates. Call this in the onCreate method with something like
     * initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
     *
     * @param context
     * @param reactInstanceManager
     */
    private static void initializeFlipper(
            Context context, ReactInstanceManager reactInstanceManager) {
        if (BuildConfig.DEBUG) {
            try {
        /*
         We use reflection here to pick up the class that initializes Flipper,
        since Flipper library is not available in release mode
        */
                Class<?> aClass = Class.forName("com.edubot.ReactNativeFlipper");
                aClass
                        .getMethod("initializeFlipper", Context.class, ReactInstanceManager.class)
                        .invoke(null, context, reactInstanceManager);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
