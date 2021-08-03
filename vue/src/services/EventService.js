import axios from 'axios';

export default {

  retrieveEvents() {
    return axios.get('/events')
  },

  retrieveEventById(eventId) {
    return axios.get(`/events/${eventId}`)
  },

  retrieveEventsByUser() {
    return axios.get(`/dashboard`)
  }

}