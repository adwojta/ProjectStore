### STAGE 1: Build ###
FROM node:16-alpine3.11 AS build
WORKDIR /frontend/src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

### STAGE 2: Run ###
FROM nginx:1.21.0-alpine
COPY --from=build /frontend/src/app/dist/frontend /usr/share/nginx/html
