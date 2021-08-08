import axios from 'axios';

export default {
    retrieveProgressByEventForAllUsers(eventId){
        return axios.get(`/progress/${eventId}`)
    },

    retrieveProgressByEventForIndividualUser(eventId){
        return axios.get(`/progress/individual/${eventId}`)
    }
        
    }