import axios from 'axios';

export default {

  retrieveEvents() {
    return axios.get('/events')
  }

}