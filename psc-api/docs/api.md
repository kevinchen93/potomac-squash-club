# API
## Setup
### Install [httpie](https://httpie.org/)
`brew install httpie`

## Courts
### List courts
`http GET localhost:8080/psc/api/court`

### Create court
`http POST localhost:8080/psc/api/court number:=1 name="Court 3"`