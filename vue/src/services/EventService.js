import axios from 'axios';

export default {

  retrieveEvents() {
    return axios.get('/events')
  },

  retrieveEventById(eventId) {
    return axios.get(`/events/${eventId}`)
  },

  retrieveEventsByUser() {
    return axios.get(`/dashboard/events`)
  },

  addUserToEvent(event) {
    return axios.post(`/myEvents`, event)
  },

  addNewEvent(event) {
    return axios.post(`/createEvent`, event)
  },

}