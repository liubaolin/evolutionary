import {
  DefaultPage,
} from './';

export default {
  path: '/home',
  name: 'Home',
  childRoutes: [
    { path: 'default-page',
      name: 'Default page',
      component: DefaultPage,
      isIndex: true,
    },
  ],
};
