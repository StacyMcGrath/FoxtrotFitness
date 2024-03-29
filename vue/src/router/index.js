import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import EventSearch from '../views/EventSearch.vue'
import EventDetailPage from '../views/EventDetailPage.vue'
import Dashboard from '../views/Dashboard.vue'
import MyActivityHistoryPage from '../views/MyActivityHistoryPage.vue'
import MyEventHistoryPage from '../views/MyEventHistoryPage.vue'
import MyGoalHistoryPage from '../views/MyGoalHistoryPage.vue'
import NewEventFormPage from '../views/NewEventFormPage.vue'
import NewGoalFormPage from '../views/NewGoalFormPage.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/events",
      name: "events",
      component: EventSearch,
      meta: {
        requiresAuth: false
      }
    },
    {
      path:"/events/:eventId",
      name: "event-details",
      component: EventDetailPage,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/dashboard/",
      name: "dashboard",
      component: Dashboard,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/myActivities",
      name: "my-activity-history",
      component: MyActivityHistoryPage,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/myEvents",
      name: "my-event-history",
      component: MyEventHistoryPage,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/myGoals",
      name: "my-goal-history",
      component: MyGoalHistoryPage,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/createEvent",
      name: "create-event",
      component: NewEventFormPage,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/createGoal",
      name: "create-goal",
      component: NewGoalFormPage,
      meta: {
        requiresAuth: true
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
