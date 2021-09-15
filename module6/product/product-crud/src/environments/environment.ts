// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  apiUrl: 'http://localhost:8080/',
  firebaseConfig: {
    apiKey: 'AIzaSyA1NU81ncGrHvwxASomNg1zPKf-OAeiyGo',
    authDomain: 'product-shoes.firebaseapp.com',
    databaseURL: 'https://product-shoes-default-rtdb.firebaseio.com',
    projectId: 'product-shoes',
    storageBucket: 'product-shoes.appspot.com',
    messagingSenderId: '625443629365',
    appId: '1:625443629365:web:b75601927fae8983a4047c',
    measurementId: 'G-NE1QEXNQX1'
  }
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
