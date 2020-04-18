set -e

useradd iwp_user
useradd iwp_app

echo iwp_user_password | passwd iwp_user --stdin
echo iwp_app_password | passwd iwp_app --stdin

envsubst '$${IWP_DB_NAME},$${IWP_DB_USER},$${IWP_DB_PASSWORD},$${IWP_DB_APP_USER},$${IWP_DB_APP_PASSWORD}' < /var/custom/db.sql_template > /var/custom/db.sql
#envsubst '$${IWP_DB_USER},$${IWP_DB_PASSWORD},$${IWP_DB_APP_USER},$${IWP_DB_APP_PASSWORD}' < add_users.sh_template > /add_users.sh

su - db2inst1 -c "db2 -stvf /var/custom/db.sql"

