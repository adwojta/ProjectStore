### STAGE 1: Build ###
FROM node:15.14.0-alpine3.10 AS build
WORKDIR /frontend/src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

### STAGE 2: Run ###
FROM nginx:1.19.10-alpine
COPY --from=build /frontend/src/app/dist/frontend /usr/share/nginx/html
