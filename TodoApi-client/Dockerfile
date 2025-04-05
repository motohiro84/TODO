# 1. Angularのビルド用ステージ
FROM node:18-alpine as build

WORKDIR /app

# Angularの依存関係をインストール
COPY ./TodoApi-client/package.json ./TodoApi-client/package-lock.json ./
RUN npm install

# ソースコードをコピーしてビルド
COPY ./TodoApi-client /app
RUN npm run build --prod

# 2. Nginx用ステージ
FROM nginx:alpine

# Nginxの設定ファイルをコピー
COPY ./TodoApi-client/nginx/nginx.conf /etc/nginx/nginx.conf

# ビルドしたアプリケーションをNginxのデフォルトのホスティングパスにコピー
COPY --from=build /app/dist/todo-api-client /usr/share/nginx/html

# ポート80を開放
EXPOSE 80
