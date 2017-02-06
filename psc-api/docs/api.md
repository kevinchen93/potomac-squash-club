# API
## Setup
### Install [httpie](https://httpie.org/)
`brew install httpie`

## Courts
### List courts
`http GET localhost:8080/psc/api/court`

### Create court
`http POST localhost:8080/psc/api/court number:=1 name="Court 3"`

### Get court
`http GET localhost:8080/psc/api/court/<COURT_ID>`

### Delete court
`http DELETE localhost:8080/psc/api/court/<COURT_ID>`

## Members
### List members
`http GET localhost:8080/psc/api/member`

### Create member
```
http POST localhost:8080/psc/api/member \
  emailAddress="kevinmichaelchen@gmail.com" \
  firstName="Kevin" \
  lastName="Chen"
```

### Get member
`http GET localhost:8080/psc/api/member/<MEMBER_ID>`

### Delete member
`http DELETE localhost:8080/psc/api/member/<MEMBER_ID>`

## Reservations
### List reservations
`http GET localhost:8080/psc/api/reservation`

### Create reservation
```
http POST localhost:8080/psc/api/reservation \
  courtID="COURT_ID" \
  memberID="MEMBER_ID" \
  time="2017-02-06T03:30:00Z"
```

### Get reservation
`http GET localhost:8080/psc/api/reservation/<RESERVATION_ID>`

### Delete reservation
`http DELETE localhost:8080/psc/api/reservation/<RESERVATION_ID>`
