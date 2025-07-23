# =================
# Stage 1: Build the React application
# =================
FROM node:18-alpine AS builder

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json to leverage Docker cache
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application source code
COPY . .

# Build the application for production
# This creates a 'build' folder with static files
RUN npm run build

# =================
# Stage 2: Create the final image with Nginx to serve the files
# =================
FROM nginx:stable-alpine

# Copy the static files from the 'builder' stage
# from the /app/build directory into the Nginx default web root
COPY --from=builder /app/build /usr/share/nginx/html

# We need to replace the default Nginx config to make sure React Router works correctly.
# See the nginx.conf file explained below.
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Expose port 80 (the default port for Nginx)
EXPOSE 80

# The base Nginx image already has a CMD to start the server,
# so we don't need to specify one here.