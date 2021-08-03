import axios from 'axios';

export default {

  logActivity(activity) {
    return axios.post('/dashboard', activity)
  },

  retrieveActivitiesByUser(){
    return axios.get(`/dashboard/activities`)
  }


}
